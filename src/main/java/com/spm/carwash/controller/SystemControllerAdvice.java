package com.spm.carwash.controller;

import com.spm.carwash.exception.PermissionDeniedException;
import com.spm.carwash.exception.UnknownException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

/**
 * Exception handler
 */
@ControllerAdvice
public class SystemControllerAdvice {

    @ExceptionHandler(value = UnknownException.class)
    public RedirectView parameterError(UnknownException e, RedirectAttributes redirectAttributes) {
        RedirectView redirectView = new RedirectView();
        redirectView.setContextRelative(true);
        redirectView.setUrl("/");
        redirectAttributes.addFlashAttribute("alertStatus", true);
        redirectAttributes.addFlashAttribute("alert", e.getMessage());
        return redirectView;
    }

    @ExceptionHandler(value = PermissionDeniedException.class)
    public RedirectView parameterError(PermissionDeniedException e, RedirectAttributes redirectAttributes) {
        RedirectView redirectView = new RedirectView();
        redirectView.setContextRelative(true);
        redirectView.setUrl("/");
        redirectAttributes.addFlashAttribute("alertStatus", true);
        redirectAttributes.addFlashAttribute("alert", e.getMessage());
        return redirectView;
    }
}
