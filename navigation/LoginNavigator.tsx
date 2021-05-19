import React from 'react';
import {StyleSheet, Text, View, TextInput, TouchableOpacity, Image, Alert} from 'react-native';
import { NavigationContainer } from '@react-navigation/native';
import {Button} from "react-native-paper";

export default class LoginNavigator extends React.Component {
    state={
        email:"",
        password:""
    }
    goHome(){
        console.log("login");
    }


    render(){
        return (
            <View style={styles.container}>
                <Image style={{height:80,width:80}} source={require('../assets/images/checklist.png')} />
                <Text style={styles.logo}>EasyPsy</Text>
                <View style={styles.inputView} >
                    <TextInput
                        style={styles.inputText}
                        placeholder="Email..."
                        placeholderTextColor="#003f5c"
                        onChangeText={text => this.setState({email:text})}/>
                </View>
                <View style={styles.inputView} >
                    <TextInput
                        secureTextEntry
                        style={styles.inputText}
                        placeholder="Password..."
                        placeholderTextColor="#003f5c"
                        onChangeText={text => this.setState({password:text})}/>
                </View>
                <TouchableOpacity>
                    <Text style={styles.forgot}>Forgot Password?</Text>
                </TouchableOpacity>
                <TouchableOpacity style={styles.loginBtn}>
                    <Text style={styles.loginText} onPress={() =>  {this.goHome()} } >Login</Text>
                    {/*<Button onPress={this.goHome} >Login</Button>*/}
                </TouchableOpacity>
                <TouchableOpacity>
                    <Text style={styles.loginText}>Signup</Text>
                </TouchableOpacity>
            </View>
        );
    }
}

const styles = StyleSheet.create({
    container: {
        flex: 1,
        backgroundColor: '#003f5c',
        alignItems: 'center',
        justifyContent: 'center',
    },
    logo:{
        fontWeight:"bold",
        fontSize:50,
        fontFamily:'American Typewriter',
        color:"rgba(19,18,18,0.57)",
        marginBottom:40
    },
    inputView:{
        width:"80%",
        backgroundColor:"#465881",
        borderRadius:25,
        height:50,
        marginBottom:20,
        justifyContent:"center",
        padding:20
    },
    inputText:{
        height:50,
        color:"white"
    },
    forgot:{
        color:"white",
        fontSize:11
    },
    loginBtn:{
        width:"80%",
        backgroundColor:"#131111",
        borderRadius:25,
        height:50,
        alignItems:"center",
        justifyContent:"center",
        marginTop:40,
        marginBottom:10
    },
    loginText:{
        color:"white"
    }
});
