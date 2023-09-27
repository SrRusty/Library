/*******************************************************************************
 * 
 * Autor: autor@axpe.com
 * 
 * © Axpe Consulting S.L. 2022. Todos los derechos reservados.
 * 
 ******************************************************************************/

package com.axpe.example.service.exceptions;

/**
 * Excepción que define un error al producirse un conflicto
 * 
 * @author kmorillo@axpe.com
 */
public class ErrorMailValidation extends DevelopmentException {
    
    /**
     * 
     */
    private static final long serialVersionUID = 5992315166274853744L;
    
    public ErrorMailValidation(ErrorCode pErrorCode) {
        super(pErrorCode);
    }
    
    public ErrorMailValidation(ErrorCode pErrorCode, Exception newOriginalException,
            Object... pArguments) {
        super(pErrorCode, newOriginalException, pArguments);
    }
    
    public ErrorMailValidation(ErrorCode pErrorCode, Exception newOriginalException) {
        super(pErrorCode, newOriginalException);
    }
    
    public ErrorMailValidation(ErrorCode pErrorCode, Object... pArguments) {
        super(pErrorCode, pArguments);
    }
    
}
