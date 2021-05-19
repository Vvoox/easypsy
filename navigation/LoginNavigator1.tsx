import React from 'react';
import { StyleSheet, Text, View } from 'react-native';

import { Asset } from 'expo-asset';
import  AppLoading  from 'expo-app-loading';
import LoginApp from './login/LoginNavigator2'
// @ts-ignore
function cacheImages(images) {
    return images.map((image: string | number) => {
        if (typeof image === 'string') {
            // @ts-ignore
            return Image.prefetch(image);
        } else {
            return Asset.fromModule(image).downloadAsync();
        }
    });
}
export default class App extends React.Component {
    constructor() {
        // @ts-ignore
        super();
        this.state = {
            isReady: false
        };
    }

    async _loadAssetsAsync() {
        const imageAssets = cacheImages([require('../assets/images/bg.png')]);

        await Promise.all([...imageAssets]);
    }

    render() {
        // @ts-ignore
        if (!this.state.isReady) {
            return (
                <AppLoading
                    startAsync={this._loadAssetsAsync}
                    onFinish={() => this.setState({ isReady: true })}
                    onError={console.warn}
                />
            );
        }
        return <LoginApp/>;
    }
}
const styles = StyleSheet.create({
    container: {
        flex: 1,
        backgroundColor: '#fff',
        alignItems: 'center',
        justifyContent: 'center'
    }
});
