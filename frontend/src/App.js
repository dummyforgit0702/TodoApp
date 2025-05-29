// import logo from './logo.svg';
// import './App.css';

// function App() {
//   return (
//     <div className="App">
//       <header className="App-header">
//         <img src={logo} className="App-logo" alt="logo" />
//         <p>
//           Edit <code>src/App.js</code> and save to reload.
//         </p>
//         <a
//           className="App-link"
//           href="https://reactjs.org"
//           target="_blank"
//           rel="noopener noreferrer"
//         >
//           Learn React
//         </a>
//       </header>
//     </div>
//   );
// }

// export default App;


// frontend/src/App.js
import React, { useState, useEffect } from 'react';
import axios from 'axios';
import './App.css'; // We'll create this basic CSS file

const API_URL = 'http://localhost:8080/api/todos'; // Your Spring Boot backend URL

function App() {
  const [todos, setTodos] = useState([]);
  const [newTodoTitle, setNewTodoTitle] = useState('');

  // Fetch todos when component mounts
  useEffect(() => {
    fetchTodos();
  }, []);

  const fetchTodos = async () => {
    try {
      const response = await axios.get(API_URL);
      setTodos(response.data);
    } catch (error) {
      console.error("Error fetching todos:", error);
      // Handle error (e.g., show a message to the user)
    }
  };

  const handleInputChange = (event) => {
    setNewTodoTitle(event.target.value);
  };

  const handleAddTodo = async (event) => {
    event.preventDefault(); // Prevent form from submitting traditionally
    if (!newTodoTitle.trim()) return; // Don't add empty todos

    try {
      const response = await axios.post(API_URL, { title: newTodoTitle, completed: false });
      // setTodos([...todos, response.data]); // Optimistic update (add locally first)
      fetchTodos(); // Or refetch all todos to ensure consistency
      setNewTodoTitle(''); // Clear input field
    } catch (error) {
      console.error("Error adding todo:", error);
      // Handle error
    }
  };

  const toggleComplete = async (todoToToggle) => {
    try {
      const updatedTodo = { ...todoToToggle, completed: !todoToToggle.completed };
      await axios.put(`${API_URL}/${todoToToggle.id}`, updatedTodo);
      fetchTodos(); // Refetch to update the list
    } catch (error) {
      console.error("Error updating todo:", error);
    }
  };

  const handleDeleteTodo = async (id) => {
    try {
      await axios.delete(`${API_URL}/${id}`);
      fetchTodos(); // Refetch to update the list
    } catch (error) {
      console.error("Error deleting todo:", error);
    }
  };


  return (
    <div className="App">
      <header className="App-header">
        <h1>Simple To-Do List</h1>
      </header>
      <main>
        <form onSubmit={handleAddTodo} className="todo-form">
          <input
            type="text"
            value={newTodoTitle}
            onChange={handleInputChange}
            placeholder="Add a new to-do..."
          />
          <button type="submit">Add</button>
        </form>
        <ul className="todo-list">
          {todos.length === 0 && <p>No todos yet. Add one!</p>}
          {todos.map(todo => (
            <li key={todo.id} className={todo.completed ? 'completed' : ''}>
              <span onClick={() => toggleComplete(todo)} style={{ cursor: 'pointer' }}>
                {todo.title}
              </span>
              <button onClick={() => handleDeleteTodo(todo.id)} className="delete-btn">
                Delete
              </button>
            </li>
          ))}
        </ul>
      </main>
    </div>
  );
}

export default App;