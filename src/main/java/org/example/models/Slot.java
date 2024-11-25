package org.example.models;

import lombok.Getter;
import lombok.Setter;
import org.example.enums.SlotStatus;

import java.util.Date;

@Getter
@Setter
public class Slot extends BaseEntity{
    private int startTime;
    private int endTime;
    private SlotStatus slotStatus;
    private static int cnt = 0;
    public Slot(int startTime, int endTime) {
        super(cnt++);
        slotStatus = SlotStatus.AVAILABLE;
        this.startTime= startTime;
        this.endTime = endTime;
    }
}
