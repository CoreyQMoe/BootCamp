package teksystems.casestudy.formbean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import teksystems.casestudy.database.entity.User;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Getter
@Setter
@ToString
public class SearchFormBean {
    @NotBlank(message = "Search field cannot be blank.")
    private String search;

    private List<User> users;
}
