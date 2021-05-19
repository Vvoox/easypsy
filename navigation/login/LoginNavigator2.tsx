import React, { Component } from 'react';
import { View, Text, StyleSheet, Image, Dimensions } from 'react-native';

const { width, height } = Dimensions.get('window');
import Animated from 'react-native-reanimated';
import {TapGestureHandler,State} from 'react-native-gesture-handler';
import Navigation from '../../navigation';

class LoginApp extends Component {
    constructor() {
        // @ts-ignore
        super();
    }
    goHome(){
        console.log("test");
    }
    render() {
        return (
            <View
                style={{
                    flex: 1,
                    backgroundColor: 'white',
                    justifyContent: 'flex-end'
                }}
            >
                <View style={{ ...StyleSheet.absoluteFill }}>
                    <Image
                        source={require('../../assets/images/bg.png')}
                        style={{ flex: 1, height: null, width: null }}
                    />
                </View>
                <View style={{ height: height / 3, justifyContent: 'center' }}>
                   <TapGestureHandler onHandlerStateChange={this.onStateChange}>
                       <View style={styles.button}>
                        <Text style={{ fontSize: 20, fontWeight: 'bold' }}
                              onPress={() => {this.goHome()}}>SIGN IN</Text>
                    </View>
                   </TapGestureHandler>
                    <View style={{ ...styles.button, backgroundColor: '#1e4710' }}>
                        <Text style={{ fontSize: 20, fontWeight: 'bold', color: 'white' }}>
                            SIGN IN WITH GOOGLE
                        </Text>
                    </View>
                </View>
            </View>
        );
    }
}
export default LoginApp;

const styles = StyleSheet.create({
    container: {
        flex: 1,
        alignItems: 'center',
        justifyContent: 'center'
    },
    button: {
        backgroundColor: 'white',
        height: 70,
        marginHorizontal: 20,
        borderRadius: 35,
        alignItems: 'center',
        justifyContent: 'center',
        marginVertical: 5
    }
});
