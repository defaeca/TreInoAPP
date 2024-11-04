let database = [];
let isEditMode = false;
let currentEditId = null;

function displayData() {
    const tableBody = document.querySelector('#dataTable tbody');
    tableBody.innerHTML = '';

    database.forEach(user => {
        const row = document.createElement('tr');

        row.innerHTML = `
            <td>${user.name}</td>
            <td>${user.email}</td>
            <td>${user.imc.toFixed(2)}</td>
            <td>
                <button onclick="prepareUpdate(${user.id})">Alterar</button>
                <button onclick="deleteRecord(${user.id})">Excluir</button>
            </td>
        `;

        tableBody.appendChild(row);
    });
}

document.getElementById('insertForm').addEventListener('submit', async function(event) {
    event.preventDefault();

    const name = document.getElementById('insertName').value;
    const email = document.getElementById('insertEmail').value;
    const height = parseFloat(document.getElementById('insertHeight').value);
    const weight = parseFloat(document.getElementById('insertWeight').value);
    const imc = weight / (height * height);

    const userData = {
        name,
        email,
        imc
    };

    if (isEditMode) {
        const userIndex = database.findIndex(record => record.id === currentEditId);
        if (userIndex !== -1) {
            database[userIndex] = { ...userData, id: currentEditId };
            await updateUserInDatabase(currentEditId, userData); // Atualiza no backend
        }
        isEditMode = false;
        currentEditId = null;
        document.getElementById('submitInsert').innerText = 'Inserir';
        document.getElementById('formHeader').innerText = 'Inserir Dados';
    } else {
        await insertUserToDatabase(userData); // Insere no backend
        const newId = database.length ? database[database.length - 1].id + 1 : 1;
        database.push({ id: newId, ...userData });
    }

    document.getElementById('insertSuccess').style.display = 'block';
    setTimeout(() => {
        document.getElementById('insertSuccess').style.display = 'none';
    }, 2000);

    resetForm();
    displayData();
    showSection('viewDataSection');
});

async function insertUserToDatabase(userData) {
    try {
        const response = await fetch('http://localhost:8081/registro', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(userData),
        });
        if (!response.ok) {
            throw new Error('Erro ao inserir dados.');
        }
    } catch (error) {
        console.error('Erro:', error);
    }
}

async function updateUserInDatabase(id, userData) {
    try {
        const response = await fetch(`http://localhost:8081/registro/${id}`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(userData),
        });
        if (!response.ok) {
            throw new Error('Erro ao atualizar dados.');
        }
    } catch (error) {
        console.error('Erro:', error);
    }
}

function prepareUpdate(id) {
    const user = database.find(record => record.id === id);
    if (user) {
        document.getElementById('insertName').value = user.name;
        document.getElementById('insertEmail').value = user.email;
        document.getElementById('insertHeight').value = '';
        document.getElementById('insertWeight').value = '';

        isEditMode = true;
        currentEditId = id;
        document.getElementById('submitInsert').innerText = 'Salvar Alterações';
        document.getElementById('formHeader').innerText = 'Alterar Dados';

        showSection('insertDataSection');
    }
}

function deleteRecord(id) {
    database = database.filter(record => record.id !== id);
    displayData();
}

function resetForm() {
    document.getElementById('insertName').value = '';
    document.getElementById('insertEmail').value = '';
    document.getElementById('insertHeight').value = '';
    document.getElementById('insertWeight').value = '';
    isEditMode = false;
    currentEditId = null;
    document.getElementById('submitInsert').innerText = 'Inserir';
    document.getElementById('formHeader').innerText = 'Inserir Dados';
}

displayData();
