import logo from './logo.svg';
import './App.css';
import "../node_modules/bootstrap/dist/css/bootstrap.min.css";
import Navbar from './layout/Navbar';
import Login from "./pages/Login";
import { BrowserRouter as Router, Routes, Route} from 'react-router-dom';
import RegisterUser from "./users/RegisterUser";
import ViewUser from "./users/ViewUser";
import EditUser from "./users/EditUser";
import Dashboard from './pages/Dashboard';

function App() {
  return (
    <div className="App">
      <Router>
        <Navbar />

        <Routes>
          <Route exact path="/" element={<Login />} />
          <Route exact path="/register" element={<RegisterUser />} />
          <Route exact path="/edituser/:id" element={<EditUser/>}/>
          <Route exact path="/viewuser/:id" element={<ViewUser/>}/>
          <Route exact path="/dashboard" element={<Dashboard/>}/>
        </Routes>
      </Router>
    </div>
  );
}

export default App;
