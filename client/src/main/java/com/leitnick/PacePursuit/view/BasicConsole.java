package com.leitnick.PacePursuit.view;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface BasicConsole {
    /**
     * Pause output until user presses enter
     */
    void pauseOutput();

    /**
     * Print message to console
     * @param message to print
     */
    void printMessage(String message);

    /**
     * Print message ending with new line to console
     * @param message to print
     * @param withLineFeed boolean
     */
    void printMessage(String message, boolean withLineFeed);

    /**
     * Print error message
     * @param message to print
     */
    void printErrorMessage(String message);

    /**
     * Print a blank new line
     */
    void printBlankLine();

    /**
     * Print n number of blank new lines
     * @param numberOfLines to print
     */
    void printBlankLines(int numberOfLines);

    /**
     * Print a divider to console
     */
    void printDivider();

    /**
     * Print banner to console
     * @param message to use in banner
     */
    void printBanner(String message);

    void printHeader(String message);

    void printSubHeader(String message);

    /**
     * Print an array to bulleted items
     * @param items to list
     */
    void printBulletedItems(String[] items);

    /**
     * Print a list to bulleted items
     * @param list to use for bulleted items
     */
    void printBulletedItems(List<String> list);

    /**
     * Choose a menu selection
     * @param options are the available choices
     * @return user's choice
     */
    String getMenuSelection(String[] options);

    /**
     * Choose a menu selection, null response allowed
     * @param options are the available choices
     * @param allowNullResponse boolean
     * @return user's choice
     */
    String getMenuSelection(String[] options, boolean allowNullResponse);

    Integer getMenuSelectionIndex(String[] options, boolean allowNullResponse);

    String promptForString(String prompt);
    boolean promptForYesNo(String prompt);
    Integer promptForInteger(String prompt);
    Double promptForDouble(String prompt);
    BigDecimal promptForBigDecimal(String prompt);
    LocalDate promptForLocalDate(String prompt);
}
