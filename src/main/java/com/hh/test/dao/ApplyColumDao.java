package com.hh.test.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hh.test.dao.entity.Xt_applyColum;

public interface ApplyColumDao {

	List<Xt_applyColum> getApplyColum();

	void addColum(Xt_applyColum applyColum);

	void delColum(@Param("id")String id);

	List<Xt_applyColum> getColumList(@Param("page")int page, @Param("rows")int rows,@Param("columName") String columName);

}
