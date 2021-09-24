import React from 'react';
import { Card, Form } from 'react-bootstrap';
import './Enquiry.css';

class Registration extends React.Component {
    
     render() {
          return (
             <div>
                 <Register/> 
             </div>
          ); 
         }
    }
  
    class Register extends React.Component {
      constructor(props) {
        super(props);
        
        this.state = {
          Message: ''
        };
      }
  
      
      onCreateEmployee=()=>{
        let Empdemo={
              "userfname":this.refs.userfname.value,
              "userlname":this.refs.userlname.value,
              "usermbno":this.refs.usermbno.value,
              "useraddress":this.refs.useraddress.value,
             "zip":this.refs.zip.value,
            //  "city":this.refs.city.value,
  
            //  "state":this.refs.state.value,
              "usermail":this.refs.usermail.value,
              "password":this.refs.password.value,
              "userdlno":this.refs.userdlno.value,
            //  "userPassportNo":this.refs.userPassportNo.value,
            //  "userAadharNo":this.refs.userAadharNo.value,
            };
            
           let demo= JSON.stringify(Empdemo);
            console.log(JSON.parse(demo));
            fetch("http://localhost:8080/save-user",{
          method: 'POST',
          headers:{'Content-type':'application/json'},
            body: demo
        }).then(r=>{r.json()}).then(res=>{
          if(res){
            this.setState({message:'New Employee is Created Successfully'});
          }
        });
        }
      
      render(){
        return(
          <div>
            
<div className="Enque_card">

<Card>
<Card.Header><h2 className="text-center"><b>Register Yourself</b></h2></Card.Header>
<Card.Body className="Enque_card_body">
<Form>
  <Form.Group className="mb-3">
    <Form.Label>First Name:</Form.Label>
    <Form.Control type="text" id="userfname" ref="userfname"  placeholder="First Name"/>
  </Form.Group>

  <Form.Group className="mb-3">
    <Form.Label>Last Name:</Form.Label>
    <Form.Control type="text" id="userlname" ref="userlname"  placeholder="First Name" />
  </Form.Group>

  <Form.Group className="mb-3">
    <Form.Label>Mobile Number:</Form.Label>
    <Form.Control type="text"ref="usermbno"  minlength="10" maxlength="10"  required />
  </Form.Group>

  <Form.Group className="mb-3">
    <Form.Label>Address:</Form.Label>
    <Form.Control type="text" ref="useraddress"  required/>
  </Form.Group>

  <Form.Group className="mb-3">
    <Form.Label>zip</Form.Label>
    <Form.Control type="text" ref="zip"  required />
  </Form.Group>

  <Form.Group className="mb-3">
    <Form.Label>Email-id:</Form.Label>
    <Form.Control type="text" ref="usermail"  required />
  </Form.Group>

  <Form.Group className="mb-3">
    <Form.Label>Password</Form.Label>
    <Form.Control type="password" ref="password" pattern="(?=.\d)(?=.[a-z])(?=.*[A-Z]).{8,}" title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters"  required />
  </Form.Group>

  <Form.Group className="mb-3">
    <Form.Label>Driving Licence No:</Form.Label>
    <Form.Control type="text" ref="userdlno"   required/>
  </Form.Group>

  
  
  <button onClick={this.onCreateEmployee}>Submit</button>

  <button type="reset" className="ms-3">Cancel</button>

  

   

    
</Form>
</Card.Body>
</Card>
            
                  </div>
                  </div>
        )
      }
    }
    
    export default Registration ;