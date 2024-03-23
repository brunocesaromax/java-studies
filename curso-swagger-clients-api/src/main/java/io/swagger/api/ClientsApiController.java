package io.swagger.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiParam;
import io.swagger.api.dao.ClientDAO;
import io.swagger.model.Client;
import io.swagger.model.Clients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.net.URI;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2022-02-16T12:44:13.813Z")

@Controller
public class ClientsApiController implements ClientsApi {

    private static final Logger log = LoggerFactory.getLogger(ClientsApiController.class);

    private ClientDAO clientDAO;

    @org.springframework.beans.factory.annotation.Autowired
    public ClientsApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.clientDAO = new ClientDAO();
    }

    public ResponseEntity<Client> create(@ApiParam(value = "", required = true) @Valid @RequestBody Client client) {
        ResponseEntity<Client> responseEntity = null;

        try {
            if (client != null) {
                Client newClient = clientDAO.save(client);

                if (newClient == null) {
                    throw new RuntimeException("Erro ao tentar cadastrar novo cliente.");
                }

                MultiValueMap<String, String> headers = buildHeaderLocation(newClient.getId());
                responseEntity = new ResponseEntity<>(newClient, headers, HttpStatus.CREATED);
            } else {
                responseEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

        } catch (Exception e) {
            log.error("Erro ao tentar cadastrar novo cliente.");
            responseEntity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return responseEntity;
    }

    private MultiValueMap<String, String> buildHeaderLocation(Integer id) {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();

        if (requestAttributes instanceof ServletRequestAttributes) {
            HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
            URI location;

            if (request.getMethod().equals("PUT")) {
                location = ServletUriComponentsBuilder.fromCurrentRequest().buildAndExpand().toUri();
            } else {
                location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
            }

            headers.add("location", location.getPath());
        }

        return headers;
    }

    public ResponseEntity<Client> update(@ApiParam(value = "Id do cliente", required = true) @PathVariable("id") Integer id,
                                         @ApiParam(value = "", required = true) @Valid @RequestBody Client client) {
        ResponseEntity<Client> responseEntity = null;

        try {
            if (client != null) {
                Client updatedClient = clientDAO.update(id, client);

                if (updatedClient == null) {
                    throw new RuntimeException("Erro ao tentar atualizar cliente existente.");
                }

                MultiValueMap<String, String> headers = buildHeaderLocation(updatedClient.getId());
                responseEntity = new ResponseEntity<>(updatedClient, headers, HttpStatus.OK);
            } else {
                responseEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

        } catch (Exception e) {
            log.error("Erro ao tentar atualizar cliente existente.");
            responseEntity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return responseEntity;
    }

    public ResponseEntity<Void> deleteById(@ApiParam(value = "Id do cliente", required = true) @PathVariable("id") Integer id) {
        ResponseEntity<Void> responseEntity = null;

        try {
            boolean isDeleted = clientDAO.delete(id);

            if (isDeleted) {
                responseEntity = new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

        } catch (Exception e) {
            log.error("Erro ao tentar remover cliente por id.");
            responseEntity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return responseEntity;
    }

    public ResponseEntity<Clients> find(@ApiParam(value = "Sobrenome do cliente") @Valid @RequestParam(value = "lastName", required = false) String lastName) {
        ResponseEntity<Clients> responseEntity = null;

        try {
            Clients clients = clientDAO.findByLastName(lastName);

            if (clients != null) {
                if (clients.size() <= 0) {
                    responseEntity = new ResponseEntity<>(clients, HttpStatus.NOT_FOUND);
                } else {
                    responseEntity = new ResponseEntity<>(clients, HttpStatus.OK);
                }
            }

        } catch (Exception e) {
            log.error("Erro ao tentar consultar clientes por sobrenome.");
            responseEntity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return responseEntity;
    }

    public ResponseEntity<Clients> findAll() {
        ResponseEntity<Clients> responseEntity = null;

        try {
            Clients clients = clientDAO.findAll();

            if (clients != null) {
                if (clients.size() <= 0) {
                    responseEntity = new ResponseEntity<>(clients, HttpStatus.NOT_FOUND);
                } else {
                    responseEntity = new ResponseEntity<>(clients, HttpStatus.OK);
                }
            }

        } catch (Exception e) {
            log.error("Erro ao tentar consultar clientes.");
            responseEntity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return responseEntity;
    }

    public ResponseEntity<Client> findById(@ApiParam(value = "Id do cliente", required = true) @PathVariable("id") Integer id) {
        ResponseEntity<Client> responseEntity = null;

        try {
            Client client = clientDAO.findById(id);

            if (client != null) {
                responseEntity = new ResponseEntity<>(client, HttpStatus.OK);
            } else {
                responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

        } catch (Exception e) {
            log.error("Erro ao tentar consultar cliente por id.");
            responseEntity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return responseEntity;
    }

    public ResponseEntity<Client> updateStatus(@ApiParam(value = "Id do cliente", required = true) @PathVariable("id") Integer id, @ApiParam(value = "Novo status do cliente", required = true, allowableValues = "\"active\", \"inactive\"") @PathVariable("status") String status) {
        ResponseEntity<Client> responseEntity = null;

        try {
            Client updatedClient = clientDAO.updateStatus(id, status);

            if (updatedClient != null) {
                responseEntity = new ResponseEntity<>(updatedClient, HttpStatus.OK);
            } else {
                responseEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

        } catch (Exception e) {
            log.error("Erro ao tentar atualizar status de cliente");
            responseEntity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return responseEntity;
    }

}
