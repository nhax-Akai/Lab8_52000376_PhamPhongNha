package tdtu.edu;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CustomErrorController implements ErrorController {
    @RequestMapping(value = "/error", method = RequestMethod.GET)
    public String errorPage(HttpServletRequest httpServletRequest, Model model) {
        String errorMsg = "";
        int httpErrorCode = getErrorCode(httpServletRequest);
        switch (httpErrorCode) {
            case 400: {
                errorMsg = "Http Error Code: 400. Bad Request";
                break;
            }
            case 401: {
                errorMsg = "Http Error Code: 401. Unauthorized";
                break;
            }
            case 404: {
                errorMsg = "Http Error Code: 404. Resource not found";
                break;
            }
            case 500: {
                errorMsg = "Http Error Code: 500. Internal Server Error";
                break;
            }
            default: {
                errorMsg = "Error ";
                break;
            }
        }
        model.addAttribute("errorMsg", errorMsg);
        return "errorPage";
    }

    private int getErrorCode(HttpServletRequest httpServletRequest) {

        Object o = httpServletRequest.getAttribute("ERROR_STATUS_CODE");
        return o == null ? 0 : (Integer) o;
    }
}
