package demo.taxi.com.util;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

public class ResponseObjectDto implements Serializable {

    private static final Logger LOGGER = LoggerFactory.getLogger(ResponseObjectDto.class);

    private Boolean status;
    private Object data;
    private String message;

    public ResponseObjectDto(Exception exception){
        LOGGER.error(ExceptionUtils.getStackTrace(exception));
        this.status = false;
        this.data = null;
        this.message = exception.getMessage();
    }

    public ResponseObjectDto(Object data) {
        this.status = true;
        this.data = data;
        this.message = "SUCCESS";
    }

    public ResponseObjectDto() {

    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}