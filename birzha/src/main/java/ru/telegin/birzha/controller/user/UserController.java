package ru.telegin.birzha.controller.user;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.telegin.birzha.payload.PagedResponse;
import ru.telegin.birzha.payload.user.UserStockResponce;
import ru.telegin.birzha.payload.user.UserSummary;
import ru.telegin.birzha.security.CurrentUser;
import ru.telegin.birzha.security.UserPrincipal;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @GetMapping("/me")
    @PreAuthorize("hasRole('USER')")
    public UserSummary getCurrentUser(@CurrentUser UserPrincipal currUser) {
        return new UserSummary(currUser.getId(), currUser.getUsername(), currUser.getFirstName(), currUser.getLastName());
    }


    @GetMapping("/stocks")
    @PreAuthorize("hasRole('USER')")
    public PagedResponse<UserStockResponce> getStocks(@CurrentUser UserPrincipal currentUser) {
        return UserStockService.getAllStocks(currentUser);
    }
}
