package com.hakim.cliApp;

import java.time.LocalDate;
import java.time.Month;
import java.util.Calendar;

public class AgeCalculator {
    private final int year;
    private final int month;
    private final int days;
    public AgeCalculator(int year,int month,int days){
        this.year=year;
        this.month=month;
        this.days=days;
    }

    public void getAge(){
        LocalDate today=LocalDate.now();
        int todayYear=today.getYear();
        int todayMonth=today.getMonth().getValue();
        int todayDays=today.getDayOfMonth();

        LocalDate userBirthDate=createDate(year,month,days);
        int year=userBirthDate.getYear();
        int month=userBirthDate.getMonth().getValue();
        int days=userBirthDate.getDayOfMonth();
        int dayOfMonth;

        int ageInYear=todayYear-year;
        int ageInMonth;
        int ageInDays;
        if(todayMonth<month){
            ageInYear-=1;
            ageInMonth=12-month+todayMonth;
        }else{
            ageInMonth=todayMonth-month;
        }

        if(todayDays<days){
            ageInDays=getTotalDayOfAMonth(Month.of(month))-days+todayDays;
        }else{
            ageInDays=todayDays-days;
        }
        ageInDays=todayDays-days;

        System.out.println("You are "+ageInYear+" years "+ageInMonth+" months "+ageInDays+" days Old.");



    }

    private int getTotalDayOfAMonth(Month month){
        boolean isLeapYear=LocalDate.now().isLeapYear();

        return switch (month){
            case JANUARY -> 31;
            case FEBRUARY -> isLeapYear ? 29 : 28;
            case MARCH -> 31;
            case APRIL -> 30;
            case MAY -> 31;
            case JUNE -> 30;
            case JULY -> 31;
            case AUGUST -> 31;
            case SEPTEMBER -> 30;
            case OCTOBER -> 31;
            case NOVEMBER -> 30;
            case DECEMBER -> 31;
        };


    }


    private LocalDate createDate(int year,int month,int days){
        return LocalDate.of(year,month,days);
    }
}
