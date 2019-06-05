package ru.itis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.itis.forms.TaskEditForm;
import ru.itis.models.Card;
import ru.itis.models.Comment;
import ru.itis.models.Task;
import ru.itis.models.TaskState;
import ru.itis.repositories.CommentRepository;
import ru.itis.repositories.TasksRepository;
import ru.itis.transfer.TaskDto;
import ru.itis.utils.FileDownloader;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static ru.itis.transfer.TaskDto.from;

@Service
public class TaskServiceImpl implements TaskService {

    private static String UPLOADED_FOLDER;

    private FileDownloader fileDownloader;

    private TasksRepository tasksRepository;

    private CommentRepository commentsRepository;

    public TaskServiceImpl(FileDownloader fileDownloader, TasksRepository tasksRepository, CommentRepository commentsRepository) {
        this.fileDownloader = fileDownloader;
        this.tasksRepository = tasksRepository;
        this.commentsRepository = commentsRepository;
    }

    @Override
    public List<Task> findCardTasks(Card card) {
        return tasksRepository.findAllByCardOrderByText(card);
    }

    @Override
    public Optional<Task> findTaskById(Long id) {
        return tasksRepository.findById(id);
    }

    @Override
    public TaskDto addTask(Task task) {
        TaskDto newTask = from(tasksRepository.save(task));
        return newTask;
    }

    @Override
    public List<List<Task>> findAllTasksInAllCards(List<Card> cards) {
        List<List<Task>> tasks = new ArrayList<>();
        for (Card card : cards) {
            tasks.add(findCardTasks(card));
        }
        return tasks;
    }

    @Override
    public void edit(String name, String text, String state,
                     MultipartFile file, Task task) {
        String photoPath = fileDownloader.upload(file, name).orElseThrow(IllegalArgumentException::new);
        System.out.println(photoPath);
        System.out.println(task.getPicturePath());
        if (!text.equals("") || !name.equals("")) {
            task.setName(name);
            task.setText(text);
            task.setState(TaskState.valueOf(state));
            task.setPicturePath(photoPath);
            tasksRepository.saveAndFlush(task);
        }
    }

    @Override
    public void addText(TaskEditForm taskEditForm, Task task) {
        task.setText(taskEditForm.getText());
        tasksRepository.saveAndFlush(task);
    }

    @Override
    public void archive(Task task) {
        task.setFlag(true);
        tasksRepository.saveAndFlush(task);
    }

    @Override
    public Comment addComment(Comment comment) {
        return commentsRepository.save(comment);
    }

    @Override
    public void changeFlag(Task task) {
        task.setFlag(false);
        tasksRepository.save(task);
    }

    @Value("${my.files-url}")
    public static void setUploadedFolder(String uploadedFolder) {
        UPLOADED_FOLDER = uploadedFolder;
    }

//    private static String getFileName(final Part part) {
//        System.out.println(part.getHeader("content-disposition"));
//        for (String content : part.getHeader("content-disposition").split(";")) {
//            if (content.trim().startsWith("filename")) {
//                return content.substring(
//                        content.indexOf('=') + 1).trim().replace("\"", "");
//            }
//        }
//        return null;
//    }
//
//    private void addFile(HttpServletRequest request) {
//        Part filePart;
//        try {
//            filePart = request.getPart("file");
//            String fileName = getFileName(filePart);
//
//            OutputStream out;
//            InputStream filecontent;
//
//            try {
//                out = new FileOutputStream(new File(path + File.separator + fileName));
//                filecontent = filePart.getInputStream();
//
//                int read = 0;
//                final byte[] bytes = new byte[512];
//
//                while ((read = filecontent.read(bytes)) != -1) {
//                    out.write(bytes, 0, read);
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        } catch (IOException | ServletException e) {
//            e.printStackTrace();
//        }
//    }
}
