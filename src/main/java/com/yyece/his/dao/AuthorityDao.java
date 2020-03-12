package com.yyece.his.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yyece.his.entity.Authority;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
/**
 * (Authority)表数据库访问层
 *
 * @author makejava
 * @since 2020-03-11 20:03:53
 */

public interface AuthorityDao extends BaseMapper<Authority> {

}