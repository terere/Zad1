package com.example.przemyslaw.zad1.Interfaces;

/**
 * Interface to communicate with async task
 */
public interface ResponseCodeInterface {
    /**
     * Method to send response code from async task
     *
     * @param responseCode integer with response code
     */
    public void responseCode(Integer responseCode);
}
