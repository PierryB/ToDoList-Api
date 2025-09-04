package com.example.to_do_list.controller;

import com.example.to_do_list.model.Task;
import com.example.to_do_list.service.TaskService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:3000/"})
@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
@Slf4j
public class TaskController {

    TaskService taskService;

    @Operation(summary = "Cria uma nova tarefa", description = "Cria uma nova tarefa e retorna os dados informados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Tarefa criada com sucesso"),
            @ApiResponse(responseCode = "500", description = "Houve um erro ao criar a tarefa, verifique as informações")
    })

    @PostMapping("/tasks")
    @ResponseStatus(HttpStatus.CREATED)
    public Task createTask(@RequestBody Task task) {
        log.info("Criando nova task com as infos [{}]", task);
        return taskService.createTask(task);
    }

    @Operation(summary = "Lista todas as tarefas", description = "Lista todas as tarefas registradas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tarefas listadas com sucesso"),
            @ApiResponse(responseCode = "500", description = "Houve um erro ao listar as tarefas")
    })

    @GetMapping("/tasks")
    @ResponseStatus(HttpStatus.OK)
    public List<Task> getAllTasks() {
        log.info("Listando todas as tasks cadastradas");
        return taskService.listAllTasks();
    }

    @Operation(summary = "Busca uma tarefa pelo id", description = "Busca uma tarefa pelo id e retorna as informações")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Tarefa encontrada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Não encontrou tarefa com o id informado")
    })

    @GetMapping("/tasks/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Task> getTaskById(@PathVariable (value = "id") Long id) {
        log.info("Buscando task com o id [{}]", id);
        return taskService.findTaskById(id);
    }

    @Operation(summary = "Altera uma tarefa pelo id", description = "Altera as informações de uma tarefa pelo id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Tarefa alterada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Houve um erro ao atualizar a tarefa - Tarefa não encontrada")
    })

    @PatchMapping("/tasks/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Task> updateTaskById(@PathVariable (value = "id") Long id, @RequestBody Task task) {
        log.info("Alterando a task com o id [{}] as novas infos são: [{}]", id, task);
        return taskService.updateTaskById(task, id);
    }

    @Operation(summary = "Deleta uma tarefa pelo id", description = "Deleta uma tarefa pelo id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Tarefa deletada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Houve um erro ao deletar a tarefa - Tarefa não encontrada")
    })

    @DeleteMapping("/tasks/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Object> deleteTaskById(@PathVariable (value = "id") Long id) {
        log.info("Excluindo task com o id [{}]", id);
        return taskService.deleteById(id);
    }
}
