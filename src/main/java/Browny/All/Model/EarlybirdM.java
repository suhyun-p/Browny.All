package Browny.All.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@AllArgsConstructor
@Data
public class EarlybirdM {
    private LocalDate deadline;
    private int amount;
}