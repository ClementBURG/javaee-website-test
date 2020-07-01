package com.octest.forms;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

public class UploadFileForm {
	public static final int BUFFER_SIZE = 10240;
    public static final String FILE_PATH = "C:/Users/burg_c/Documents/octest_files/";
	
	public void uploadFile(HttpServletRequest request) throws IOException, ServletException {
		String description = request.getParameter("description");
        request.setAttribute("description", description );

        // File field
        Part part = request.getPart("file");
            
        // Check file received
        String fileName = this.getFileName(part);

        if (fileName != null && !fileName.isEmpty()) {
            String fieldName = part.getName();
            // Correct an Internet Explorer bug
            fileName = fileName.substring(fileName.lastIndexOf('/') + 1)
                    .substring(fileName.lastIndexOf('\\') + 1);

            // Write file on disk
            this.writeFile(part, fileName, FILE_PATH);

            request.setAttribute(fieldName, fileName);
        }
	}
	
	private void writeFile(Part part, String fileName, String path) throws IOException {
        BufferedInputStream in = null;
        BufferedOutputStream out = null;
        try {
            in = new BufferedInputStream(part.getInputStream(), BUFFER_SIZE);
            out = new BufferedOutputStream(new FileOutputStream(new File(path + fileName)), BUFFER_SIZE);

            byte[] buffer = new byte[BUFFER_SIZE];
            int length;
            while ((length = in.read(buffer)) > 0) {
                out.write(buffer, 0, length);
            }
        } finally {
            try {
                out.close();
            } catch (IOException ignore) {
            }
            try {
                in.close();
            } catch (IOException ignore) {
            }
        }
    }
    
    private String getFileName(Part part) {
        for ( String contentDisposition : part.getHeader( "content-disposition" ).split( ";" ) ) {
            if ( contentDisposition.trim().startsWith( "filename" ) ) {
                return contentDisposition.substring( contentDisposition.indexOf( '=' ) + 1 ).trim().replace( "\"", "" );
            }
        }
        return null;
    } 
}
