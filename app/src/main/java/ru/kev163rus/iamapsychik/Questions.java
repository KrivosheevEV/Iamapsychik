package ru.kev163rus.iamapsychik;

import java.lang.reflect.Array;

/**
 * Created by Админ on 31.01.2016.
 */
public class Questions {

    static int indexOfQuestion, countOfQuestions;
    static boolean itFastTest, itFullTest, itAddTest;
    static int arrayUserResult[];

    public void setUserResult(int currentQuestion, int userResult){

        if (currentQuestion < indexOfQuestion){

        }else if (currentQuestion > indexOfQuestion){
            currentQuestion = indexOfQuestion;
        }

        arrayUserResult[currentQuestion] = userResult;


    }


}
