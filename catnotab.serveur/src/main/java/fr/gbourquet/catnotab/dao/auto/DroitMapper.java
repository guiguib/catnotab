package fr.gbourquet.catnotab.dao.auto;

import fr.gbourquet.catnotab.serveur.metier.auto.Droit;
import fr.gbourquet.catnotab.serveur.metier.auto.DroitExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DroitMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table catnotab.droit
     *
     * @mbggenerated Wed Aug 29 10:14:35 CEST 2012
     */
    int countByExample(DroitExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table catnotab.droit
     *
     * @mbggenerated Wed Aug 29 10:14:35 CEST 2012
     */
    int deleteByExample(DroitExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table catnotab.droit
     *
     * @mbggenerated Wed Aug 29 10:14:35 CEST 2012
     */
    int deleteByPrimaryKey(String code);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table catnotab.droit
     *
     * @mbggenerated Wed Aug 29 10:14:35 CEST 2012
     */
    int insert(Droit record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table catnotab.droit
     *
     * @mbggenerated Wed Aug 29 10:14:35 CEST 2012
     */
    int insertSelective(Droit record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table catnotab.droit
     *
     * @mbggenerated Wed Aug 29 10:14:35 CEST 2012
     */
    List<Droit> selectByExample(DroitExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table catnotab.droit
     *
     * @mbggenerated Wed Aug 29 10:14:35 CEST 2012
     */
    Droit selectByPrimaryKey(String code);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table catnotab.droit
     *
     * @mbggenerated Wed Aug 29 10:14:35 CEST 2012
     */
    int updateByExampleSelective(@Param("record") Droit record, @Param("example") DroitExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table catnotab.droit
     *
     * @mbggenerated Wed Aug 29 10:14:35 CEST 2012
     */
    int updateByExample(@Param("record") Droit record, @Param("example") DroitExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table catnotab.droit
     *
     * @mbggenerated Wed Aug 29 10:14:35 CEST 2012
     */
    int updateByPrimaryKeySelective(Droit record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table catnotab.droit
     *
     * @mbggenerated Wed Aug 29 10:14:35 CEST 2012
     */
    int updateByPrimaryKey(Droit record);
}