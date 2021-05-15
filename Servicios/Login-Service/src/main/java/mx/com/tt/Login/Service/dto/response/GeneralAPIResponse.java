package mx.com.tt.Login.Service.dto.response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

import java.io.Serializable;

public class GeneralAPIResponse implements Serializable {

    @Autowired
    private MessageSource messageSource;

    private String code;
    private String message;
    private Object response;

    public GeneralAPIResponse(String code, String message, Object response) {
        this.code = code;
        this.message = message;
        this.response = response;
    }

    public GeneralAPIResponse(String code) {
        String msg = "Ha ocurrido un error inesperado.";
        try {
            msg = messageSource.getMessage("response.error." + code, null,
                    LocaleContextHolder.getLocale());
        } catch (NullPointerException e) {
            e.printStackTrace();
            //LOGGER.error("Error al consultar mensaje de error: " + code, e);
        }

        this.code = code;
        this.message = msg;
        this.response = null;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getResponse() {
        return response;
    }

    public void setResponse(Object response) {
        this.response = response;
    }
}
