package br.com.training.service;

import br.com.training.model.User;
import br.com.training.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
    @Mock
    private UserRepository userRepository;

    private UserService userService;



    @Test
    void exibirUserList() {
        List<User> mocksUserList = new ArrayList<>();
        User mockUser = new User();
        mockUser.setName("maria");
        mocksUserList.add(mockUser);
        when(userRepository.findAll()).thenReturn(mocksUserList);

        List<User> response = userService.getAll();
        assertEquals(response.size(), 1);
        assertEquals(response.get(0).getName(), "maria");

    }

//@Test
//void exibirUsuariosTest(){
    //UsuarioService mockUsuario = Mockito.mock(UsuarioService.class);
    //List<UsuarioModel> todosOsUsuarios = mockUsuario.todosUsuarios();
    //Assertions.assertTrue(todosOsUsuarios.isEmpty());
//}
}
