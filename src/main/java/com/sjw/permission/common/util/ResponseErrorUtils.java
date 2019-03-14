package com.sjw.permission.common.util;

import com.google.gson.Gson;
import com.sjw.permission.common.vo.Result;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @author sjw
 * @date 2019/3/14
 */
public class ResponseErrorUtils {
    public ResponseErrorUtils() {
    }

    public static void sendError(int httpStatus, String msg, String forwardUri, HttpServletRequest request, HttpServletResponse response) {
        response.setStatus(httpStatus);
        String uri = request.getRequestURI();
        if (isApiRequest(uri)) {
            sendJsonError(httpStatus, msg, response);
        } else {
            sendPage(httpStatus, forwardUri, request, response);
        }

    }

    private static void sendPage(int httpStatus, String forwardUri, HttpServletRequest request, HttpServletResponse response) {
        try {
            response.setStatus(httpStatus);
            request.getRequestDispatcher(forwardUri).forward(request, response);
        } catch (Exception var5) {
            throw new RuntimeException(var5.getMessage(), var5);
        }
    }

    public static void sendJsonError(int httpStatus, String msg, HttpServletResponse response) {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.setStatus(httpStatus);

        try {
            PrintWriter writer = response.getWriter();
            Throwable var4 = null;

            try {
                writer.write((new Gson()).toJson(Result.genFail(msg)));
            } catch (Throwable var14) {
                var4 = var14;
                throw var14;
            } finally {
                if (writer != null) {
                    if (var4 != null) {
                        try {
                            writer.close();
                        } catch (Throwable var13) {
                            var4.addSuppressed(var13);
                        }
                    } else {
                        writer.close();
                    }
                }

            }

        } catch (Exception var16) {
            throw new RuntimeException(var16.getMessage(), var16);
        }
    }

    private static boolean isApiRequest(String uri) {
        return uri.contains(".json");
    }

}
