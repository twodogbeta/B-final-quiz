package com.example.demo.domain;

package com.example.demo.repository.entity;

import com.example.demo.service.domain.Groups;
import com.example.demo.service.domain.Trainer;
import com.example.demo.vo.GroupVo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "group")
public class Group {
    @Id
    private Long id;
    private String name;
}