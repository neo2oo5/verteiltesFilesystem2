package com.vs2.origin;

import javax.swing.*;

/**
 * Hilfs-Klasse zum erstellen kleiner Popups
 * -Information
 * -Warnung
 * -Fehler
 * -Text eingabe
 *
 * @author Kevin Bonner  - kevin.bonner@gmx.de
 */
public class GuiPromptHelper
{

    /**
     * Zeigt ein Informations Popup
     */
    final public static int showInformation = 1;

    /**
     * Zeigt ein Warnung Popup
     */
    final public static int showWarning = 2;

    /**
     * Zeigt ein Fehler Popup
     */
    final public static int showError = 3;

    /**
     *  Zeigt ein Informations Popup
     */
    final public static int showQuestion = 4;

    /**
     * Zeigt ein Text eingabe Popup
     */
    final public static int showInput = 5;
    private String input = "";

    /**
     *
     */
    public GuiPromptHelper()
    {
        //default constructor
    }

    /**
     *
     * @param mode
     * @param msg
     */
    public GuiPromptHelper(int mode, String msg)
    {

        switch (mode)
        {
            case 0:
                break;
            case 1:
                showInformation(msg);
                break;
            case 2:
                showWarning(msg);
                break;
            case 3:
                showError(msg);
                break;
            case 4:
                showQuestion(msg);
                break;
            case 5:
                showInput(msg);
                break;

        }

    }

    /**
     *
     * @param mode
     * @param msg
     */
    public String show(int mode, String msg)
    {

        switch (mode)
        {
            case 0:
                break;
            case 1:
                showInformation(msg);
                break;
            case 2:
                showWarning(msg);
                break;
            case 3:
                showError(msg);
                break;
            case 4:
                return showQuestion(msg);
                
            case 5:
                return showInput(msg);
                

        }
        
        return "";

    }

    private void showInformation(String msg)
    {
        JOptionPane.showMessageDialog(null, msg);
    }

    private void showWarning(String msg)
    {
        JOptionPane.showMessageDialog(null, msg, "Warning", JOptionPane.WARNING_MESSAGE);
    }

    private void showError(String msg)
    {
        JOptionPane.showMessageDialog(null, msg, "Error", JOptionPane.ERROR_MESSAGE);
    }

    private String showQuestion(String msg)
    {
        return String.valueOf(showQuestion(msg, null));
    }

    public int showQuestion(String msg, String title)
    {
        Object[] options =
        {
            "Yes, please", "No, thanks"
        };

        int n = JOptionPane.showOptionDialog(null, msg, title,
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null, options, options[0]);

        return n;
    }

    private String showInput(String msg)
    {
        return JOptionPane.showInputDialog(null, msg);
    }


}
