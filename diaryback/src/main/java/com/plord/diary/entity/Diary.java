package com.plord.diary.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author admin
 * @since 2021-10-10
 */
@Data
  @EqualsAndHashCode(callSuper = false)
    public class Diary implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "diaryid", type = IdType.AUTO)
      private Integer diaryid;

    private String userid;

    private String title;

    private String weather;

    private LocalDate data;

    private String content;

    private int weight;


}
