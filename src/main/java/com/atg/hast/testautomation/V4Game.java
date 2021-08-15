package com.atg.hast.testautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class V4Game extends Initialization {

    private Actions actions;
    private WebElement button;
    private int numberOfHorsesInRace;
    private String vType_1 = "1";
    private String vType_2 = "2";
    private String vType_3 = "3";
    private String vType_4 = "4";

    int v_1_horsesToBeMarked = 4;
    int v_2_horsesToBeMarked = 1;
    int v_3_horsesToBeMarked = 2;
    int v_4_horsesToBeMarked;

    public boolean vType1_Mark_Horses() {

        numberOfHorsesInRace = countNumberOfHorsesFunction(vType_1);
        return markHorsesFunction(vType_1, numberOfHorsesInRace, v_1_horsesToBeMarked);
    }

    public boolean vType2_Mark_Horses() {

        numberOfHorsesInRace = countNumberOfHorsesFunction(vType_2);
        return markHorsesFunction(vType_2, numberOfHorsesInRace, v_2_horsesToBeMarked);
    }

    public boolean v4Type3_Mark_Horses() {

        numberOfHorsesInRace = countNumberOfHorsesFunction(vType_3);
        return markHorsesFunction(vType_3, numberOfHorsesInRace, v_3_horsesToBeMarked);
    }

    public boolean v4Type4_Mark_Horses() {

        v_4_horsesToBeMarked = numberOfHorsesInRace = countNumberOfHorsesFunction(vType_4);
        return markHorsesFunction(vType_4, numberOfHorsesInRace, v_4_horsesToBeMarked);
    }


    public int countNumberOfHorsesFunction(String vType) {


        System.out.println("---------------------------------------------------------");
        boolean loopCondition = true;
        int count = 1;

        while (loopCondition) {

            try {

                button = driver.findElement(By.xpath("//table[@data-test-id=\"startlist-race-" + vType + "\"] //button[@data-start-number='" + count + "']"));

                numberOfHorsesInRace = count;
                ++count;
            } catch (Exception ex) {
                loopCondition = false;

                System.out.println("Total number of horses in the race =" + numberOfHorsesInRace);
                System.out.println("-------------------------------------------------");


            }
        }
        return numberOfHorsesInRace;


    }

    public boolean markHorsesFunction(String v4Type, int numberOfHorsesInRace, int horsesToBeMarked) {

        actions = new Actions(driver);
        int count = 1;

        if (horsesToBeMarked <= numberOfHorsesInRace) {

            while (horsesToBeMarked > 0) {

                try {
                    button = driver.findElement(By.xpath("//table[@data-test-id=\"startlist-race-" + v4Type + "\"] //button[@data-start-number='" + count + "']"));
                    actions.moveToElement(button).perform();

                    button.click();
                    System.out.println("Horse number  " + button.getText() + " in list marked");

                    if (button.getAttribute("data-test-selected").equals("false")) {
                        return false;
                    }

                    horsesToBeMarked--;
                    count++;

                } catch (Exception ex) {
                    System.out.println("This is exception type =" + ex);
                }

            }

        }
        System.out.println("\n" + "------------------------------------");
        return true;

    }
}
