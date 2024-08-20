package com.imesh.ecom.Ecom.util;

//To convert binary data to boolean and other types

import org.springframework.stereotype.Service;

import java.io.*;
import java.sql.Blob;
import java.sql.SQLException;
import java.nio.charset.StandardCharsets;

/**
 * FileDataExtractor is a service class for converting binary data to various types.
 * It provides methods for converting Blob to byte array, byte array to String, and extracting actual file names from InputStreamReader.
 */
@Service
public class FileDataExtractor {

    /**
     * Converts a Blob to a byte array.
     *
     * @param blob the Blob to be converted
     * @return the byte array representation of the Blob
     * @throws SQLException if a database access error occurs
     * @throws IOException  if an I/O error occurs
     */
    public byte[] blobToByteArray(Blob blob) throws SQLException, IOException {
        if (blob == null) {
            return new byte[0];
        }
        try (InputStream inputStream = blob.getBinaryStream();
             ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {

            byte[] buffer = new byte[4096];
            int byteRead;
            while ((byteRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, byteRead);
            }
            return outputStream.toByteArray();
        }
    }

    /**
     * Converts a byte array to a String.
     *
     * @param byteArray the byte array to be converted
     * @return the String representation of the byte array
     */
    public String byteArrayToString(byte[] byteArray) {
        if (byteArray == null || byteArray.length == 0) {
            return null;
        }
        return new String(byteArray, StandardCharsets.UTF_8);
    }

    /**
     * Extracts the actual file name from an InputStreamReader.
     *
     * @param streamReader the InputStreamReader to be read
     * @return the extracted file name as a String
     * @throws SQLException if a database access error occurs
     * @throws IOException  if an I/O error occurs
     */
    public String extractActualFileName(InputStreamReader streamReader) throws SQLException, IOException {
        try {
            StringBuffer buffer = new StringBuffer();
            String temp;
            BufferedReader bufferReader = new BufferedReader(streamReader);
            while ((temp = bufferReader.readLine()) != null) {
                buffer.append(temp);
            }
            return buffer.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}