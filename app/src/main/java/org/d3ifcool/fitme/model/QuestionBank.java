package org.d3ifcool.fitme.model;

import java.util.Random;

public class QuestionBank {
    private String textQuestions [] = {
            "1. Masa remaja dimulai dari usia?",
            "2. Menu Pelengkap 4 sehat 5 sempurna?",
            "3. Menu yang mengandung karbohidrat, kecuali?",
            "4. Vitamin A berfungsi untuk menjaga kesehatan?",
            "5. Berikut ini penyakit infeksi menular seksual?"
    };

    // array of multiple choices for each question
    private String multipleChoice [][] = {
            {"10 Tahun", "15 Tahun", "17 Tahun", "13 Tahun"},
            {"Ikan", "Sayur", "Susu", "Buah"},
            {"Kentang", "Daging", "Singkong", "Gandum"},
            {"Gigi", "Telinga", "Tulang", "Mata"},
            {"Herpes", "Flu", "HIV/AIDS", "Syphilis"}
    };

    private String mCorrectAnswers[] = {"10 Tahun", "Susu", "Daging", "Mata", "HIV/AIDS"};

    public int getLength(){
        return textQuestions.length;
    }

    public String getQuestion(int a) {
//        String question = textQuestions[a];
//        return question;
        Random random = new Random();
        String randomQuestion = textQuestions[random.nextInt(5)];
        return randomQuestion;
    }

    public String getChoice(int index, int num) {
        String choice0 = multipleChoice[index][num-1];
        return choice0;
    }

    public String getCorrectAnswer(int a) {
        String answer = mCorrectAnswers[a];
        return answer;
    }
}
