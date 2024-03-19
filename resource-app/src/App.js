import './App.css';
import {Container} from "react-bootstrap";
import LandingPage from "./pages/LandingPage";
import {BrowserRouter, Route, Routes} from "react-router-dom";




function App() {
  return (
      <div className="App">
            <Container>
              <BrowserRouter>
                    <Routes>
                        <Route path={'/'} element={<LandingPage/>}/>
                        <Route path={'/contact'} element={}/>
                    </Routes>
              </BrowserRouter>
            </Container>
      </div>
  );
}

export default App;
