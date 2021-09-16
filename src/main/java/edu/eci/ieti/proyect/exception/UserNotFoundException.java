package edu.eci.ieti.proyect.exception;


import edu.eci.ieti.proyect.error.ErrorCodeEnum;
import edu.eci.ieti.proyect.error.InternalServerErrorException;
import org.springframework.http.HttpStatus;

public class UserNotFoundException
        extends InternalServerErrorException
{
    public UserNotFoundException()
    {
        super( new ServerErrorResponseDto( "User not found", ErrorCodeEnum.USER_NOT_FOUND, HttpStatus.NOT_FOUND ),
                HttpStatus.NOT_FOUND );
    }
}