import * as WebBrowser from 'expo-web-browser';
import React, {useState} from 'react';
import {Button, TextInput, TouchableOpacity} from 'react-native';

import Colors from '../constants/Colors';
import { MonoText } from './StyledText';
import { Text, View } from './Themed';
import { Alert, Modal, StyleSheet, TouchableHighlight } from 'react-native';
import Dialog from "react-native-dialog";

export default function EditScreenInfo({ path }: { path: string }) {
  const [modalVisible, setModalVisible] = useState(false);
  const createThreeButtonAlert = () =>
      Alert.alert(
          "Alert Title",
          "My Alert Msg",
          [
            {
              text: "Ask me later",
              onPress: () => console.log("Ask me later pressed")
            },
            {
              text: "Cancel",
              onPress: () => console.log("Cancel Pressed"),
              style: "cancel"
            },
            { text: "OK", onPress: () => console.log("OK Pressed") }
          ],
          { cancelable: false }
      );

  const [visible, setVisible] = useState(false);

  const showDialog = () => {
    setVisible(true);
  };

  const handleCancel = () => {
    setVisible(false);
  };

  const handleAdd = () => {
    // The user has pressed the "Delete" button, so here you can do your own logic.
    // ...Your logic
    setVisible(false);
  };
  return (
    <View>
      <View style={styles.getStartedContainer}>
        {/*<Button title="Add Patient" onPress={createThreeButtonAlert} />*/}
        {/*<Modal*/}
        {/*    animationType="slide"*/}
        {/*    transparent={true}*/}
        {/*    visible={modalVisible}*/}
        {/*    onRequestClose={() => {*/}
        {/*      Alert.alert('Modal has been closed.');*/}
        {/*    }}>*/}
        {/*  <View style={styles.centeredView}>*/}
        {/*    <View style={styles.modalView}>*/}
        {/*      <Text style={styles.modalText}>Patient Name</Text>*/}
        {/*      <TextInput placeholder="Enter something..."*/}
        {/*                 style={styles.modalInput} />*/}
        {/*      <Text style={styles.modalText}>Maladie</Text>*/}
        {/*      <TextInput placeholder="Enter something..."*/}
        {/*                 style={styles.modalInput} />*/}
        {/*      <TouchableHighlight*/}
        {/*          style={{ ...styles.openButton, backgroundColor: '#2196F3' }}*/}
        {/*          onPress={() => {*/}
        {/*            setModalVisible(!modalVisible);*/}
        {/*          }}>*/}
        {/*        <Text style={styles.textStyle}>Valider</Text>*/}
        {/*          /!*<input>Nom</input>*!/*/}
        {/*      </TouchableHighlight>*/}

        {/*    </View>*/}
        {/*  </View>*/}
        {/*</Modal>*/}

        {/*<TouchableHighlight*/}
        {/*    style={styles.openButton}*/}
        {/*    onPress={() => {*/}
        {/*      setModalVisible(true);*/}
        {/*    }}>*/}
        {/*  <Text style={styles.textStyle}>Ajouter Dossier</Text>*/}
        {/*</TouchableHighlight>*/}

      </View>



      <View style={styles.helpContainer}>
        <Button color="#007ff9" title="Ajouter Dossier" onPress={showDialog} />
        <Dialog.Container visible={visible}>
          <Dialog.Title>Information du dossier</Dialog.Title>
          {/*<Dialog.Title>Nom du Patient</Dialog.Title>*/}
          <Dialog.Input label="nom du patient"/>
          <Dialog.Input label="maladie"/>
          <Dialog.Description>Ajouter le dossier du patient ici : </Dialog.Description>
          <Dialog.Button label="Annuler" onPress={handleCancel} />
          <Dialog.Button label="Valider" onPress={handleAdd} />
        </Dialog.Container>
      </View>

      <View style={styles.helpContainer}>
        <TouchableOpacity onPress={handleHelpPress} style={styles.helpLink}>
          <Text style={styles.helpLinkText} lightColor={Colors.light.tint}>
            Aucun dossier disponible
          </Text>
        </TouchableOpacity>
      </View>
    </View>
  );
}

function handleHelpPress() {
  WebBrowser.openBrowserAsync(
    'https://docs.expo.io/get-started/create-a-new-app/#opening-the-app-on-your-phonetablet'
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
  },
  developmentModeText: {
    marginBottom: 20,
    fontSize: 14,
    lineHeight: 19,
    textAlign: 'center',
  },
  contentContainer: {
    paddingTop: 30,
  },
  welcomeContainer: {
    alignItems: 'center',
    marginTop: 10,
    marginBottom: 20,
  },
  welcomeImage: {
    width: 100,
    height: 80,
    resizeMode: 'contain',
    marginTop: 3,
    marginLeft: -10,
  },
  getStartedContainer: {
    alignItems: 'center',
    marginHorizontal: 50,
  },
  homeScreenFilename: {
    marginVertical: 7,
  },
  codeHighlightText: {
    color: 'rgba(96,100,109, 0.8)',
  },
  codeHighlightContainer: {
    borderRadius: 3,
    paddingHorizontal: 4,
  },
  getStartedText: {
    fontSize: 17,
    lineHeight: 24,
    textAlign: 'center',
  },
  helpContainer: {
    marginTop: 15,
    marginHorizontal: 20,
    alignItems: 'center',
  },
  helpLink: {
    paddingVertical: 15,
  },
  helpLinkText: {
    textAlign: 'center',
  },
  centeredView: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    marginTop: 22,
  },
  modalView: {
    margin: 20,
    backgroundColor: 'white',
    borderRadius: 20,
    padding: 35,
    alignItems: 'center',
    shadowColor: '#000',
    shadowOffset: {
      width: 0,
      height: 2,
    },
    shadowOpacity: 0.25,
    shadowRadius: 3.84,
    elevation: 5,
  },
  openButton: {
    backgroundColor: '#1749cb',
    borderRadius: 20,
    padding: 10,
    elevation: 2,
  },
  textStyle: {
    color: 'white',
    fontWeight: 'bold',
    textAlign: 'center',
  },
  modalText: {
    color:"#13519c",
    marginBottom: 15,
    textAlign: 'center',
  },
  modalInput: {
    color:"#13519c",
    // backgroundColor:"#282b2d",
    marginBottom: 15,
    textAlign: 'center',
  },
});
