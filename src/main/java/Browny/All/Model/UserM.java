package Browny.All.Model;

import Browny.All.Enum.Sex;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@RequiredArgsConstructor
@Data
public class UserM {
    @NonNull private Long userNo;
    @NonNull private String nickname;
    @NonNull private Sex sex;
    @NonNull private Boolean instructor;
    private String account;
    private List<String> careerList = new ArrayList<>();
    private InstructorContactM contact;
}