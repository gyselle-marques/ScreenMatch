<h1 align="center"> :tv: Screen Match :tv: </h1>

<div align="center">

<p>Screen Match é uma aplicação full stack para consulta, exibição e gerenciamento de séries, utilizando Java (Spring Boot) no backend e HTML/CSS/JS no frontend.</p>

*A versão CommandLineRunner está disponível [neste repositório](https://github.com/gyselle-marques/ScreenMatch-CommandLineRunner).*
</div>

## :gear: Funcionalidades
- Listagem de séries
- Visualização de detalhes de séries e episódios
- Tradução de informações via integração com APIs externas
- Interface Web responsiva

## :pushpin: Estrutura do Projeto
```
├── backend/   # Código fonte do backend (Java Spring Boot)
├── frontend/  # Arquivos do frontend (HTML, CSS, JS)
```

## :computer: Pré-requisitos
- Java 17 ou superior
- Maven 3.8 ou superior
- Navegador web

## :arrow_forward: Como Executar

### :large_blue_diamond: Backend
1. Acesse a pasta `backend`:
   ```bash
   cd backend
   ```
2. Compile e execute o projeto Spring Boot:
   ```bash
   mvnw spring-boot:run
   ```
3. O backend estará disponível em: `http://localhost:8080`

### :large_blue_diamond: Frontend
1. Acesse a pasta `frontend`.
2. Abra o arquivo `index.html` em seu navegador.

## :pencil2: Observações
- Certifique-se de que o backend esteja rodando antes de acessar o frontend.
- As configurações de CORS já estão habilitadas para facilitar o desenvolvimento local.

## :page_facing_up: Licença
Este projeto está licenciado sob a licença MIT. Veja o arquivo `LICENSE.txt` para mais detalhes.
