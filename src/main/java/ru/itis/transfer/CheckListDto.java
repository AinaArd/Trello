package ru.itis.transfer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.models.CheckList;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CheckListDto {
    private Long id;
    private String name;

    public static CheckListDto from(CheckList checkList) {
        return CheckListDto.builder()
                .id(checkList.getId())
                .name(checkList.getName())
                .build();
    }
}
