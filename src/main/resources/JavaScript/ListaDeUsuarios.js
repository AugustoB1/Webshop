document.addEventListener("DOMContentLoaded", function () {
    const userList = document.getElementById("userList");

    const users = [
      { nome: "Usuário 1", email: "usuario1@example.com",status: true ,grupo: "Grupo A", editar:"Editar" },
      { nome: "Usuário 2", email: "usuario2@example.com",status: true ,grupo: "Grupo B", editar:"Editar" },
      { nome: "Usuário 3", email: "usuario3@example.com",status: false ,grupo: "Grupo C", editar:"Editar" }

      // Adicione mais objetos de usuário conforme necessário
    ];

    users.forEach(user => {
      const row = document.createElement("tr");
      row.innerHTML = `
        <td>${user.nome}</td>
        <td>${user.email}</td>
        <td><label class="switch"><input type="checkbox" ${user.status ? 'checked' : ''}><span class="slider round"></span></label></td>
        <td>${user.grupo}</td>
        <td>${user.editar}</td>

      `;
      userList.appendChild(row);
    });
  });
