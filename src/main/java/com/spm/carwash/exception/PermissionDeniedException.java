package com.spm.carwash.exception;

/**
 * @author Yangzhe Xie
 * @date 10/10/19
 */
public class PermissionDeniedException extends Exception {
    public PermissionDeniedException() {
        super("Permission denied!");
    }
}
