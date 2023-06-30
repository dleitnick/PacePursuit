package com.leitnick.PacePursuit.view;

import com.leitnick.PacePursuit.util.ColorUtil;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class Console implements BasicConsole {

    private ColorUtil banner = new ColorUtil();
    private ColorUtil header = new ColorUtil(5, 0);
    private ColorUtil subHeader = new ColorUtil(5, 0, false);
    @Override
    public void pauseOutput() {

    }

    @Override
    public void printMessage(String message) {

    }

    @Override
    public void printMessage(String message, boolean withLineFeed) {

    }

    @Override
    public void printErrorMessage(String message) {

    }

    @Override
    public void printBlankLine() {

    }

    @Override
    public void printBlankLines(int numberOfLines) {

    }

    @Override
    public void printDivider() {

    }

    @Override
    public void printBanner(String message) {
        banner.print(message);
    }

    @Override
    public void printHeader(String message) {
        header.print(message);
    }

    @Override
    public void printSubHeader(String message) {
        subHeader.print(message);
    }

    @Override
    public void printBulletedItems(String[] items) {

    }

    @Override
    public void printBulletedItems(List<String> list) {

    }

    @Override
    public String getMenuSelection(String[] options) {
        return null;
    }

    @Override
    public String getMenuSelection(String[] options, boolean allowNullResponse) {
        return null;
    }

    @Override
    public Integer getMenuSelectionIndex(String[] options, boolean allowNullResponse) {
        return null;
    }

    @Override
    public String promptForString(String prompt) {
        return null;
    }

    @Override
    public boolean promptForYesNo(String prompt) {
        return false;
    }

    @Override
    public Integer promptForInteger(String prompt) {
        return null;
    }

    @Override
    public Double promptForDouble(String prompt) {
        return null;
    }

    @Override
    public BigDecimal promptForBigDecimal(String prompt) {
        return null;
    }

    @Override
    public LocalDate promptForLocalDate(String prompt) {
        return null;
    }
}
