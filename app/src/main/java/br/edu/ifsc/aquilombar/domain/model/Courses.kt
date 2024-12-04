package br.edu.ifsc.aquilombar.domain.model

import kotlin.math.*

data class Courses(
    val pk: Int,
    val link: String,
    val addition_info: String,
    val vacancies: Int,
    val course: Course,
    val campus: Int
){

    fun publicSchool(): Int{
        return ceil(vacancies.toDouble().div(2)).toInt()
    }

    fun wideCompetition(): Int{
        return vacancies-publicSchool()
    }

    private fun lowerIncome(): Int{
        return ceil(publicSchool().div(2).toDouble()).toInt()
    }

    private fun higherIncome(): Int{
        return publicSchool() - lowerIncome()
    }

    private fun PPILowerIncome(): Int{
        return ceil(lowerIncome()*0.157).toInt()
    }

    private fun NoPPILowerIncome(): Int{
        return lowerIncome()-PPILowerIncome()
    }

    private fun PPIHigherIncome(): Int{
        return ceil(higherIncome()*0.157).toInt()
    }

    private fun NoPPIHigerIncome(): Int{
        return higherIncome()-PPIHigherIncome()
    }

    /**
     * RS -> Renda Superior
     * RI -> Renda Inferior
     * NPPI -> Não Preto | Pardo | Indígena
     * PPI -> Preto | Pardo | Indígena
     * CD -> Com Deficiência
     */

    fun RSPPIPCD(): Int{
        return ceil(PPIHigherIncome()*0.0769).toInt()
    }

    fun RSPPI(): Int{
        return PPIHigherIncome()-RSPPIPCD()
    }

    fun RSNPPIPCD(): Int{
        return ceil(NoPPIHigerIncome()*0.0769).toInt()
    }

    fun RSNPPI(): Int{
        return NoPPIHigerIncome()-RSPPIPCD()
    }

    fun RIPPIPCD(): Int{
        return ceil(PPILowerIncome()*0.0769).toInt()
    }

    fun RIPPI(): Int{
        return PPILowerIncome()-RIPPIPCD()
    }

    fun RINPPIPCD(): Int{
        return ceil(PPILowerIncome()*0.0769).toInt()
    }

    fun RINPPI(): Int{
        return NoPPILowerIncome() - RINPPIPCD()
    }

}