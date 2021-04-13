import * as React from 'react';
import {Settings, StyleSheet} from 'react-native';

import EditScreenInfo from '../components/EditScreenInfo';
import { Text, View } from '../components/Themed';
import ProfilePage from "../components/ProfilePage";

export default function ProfileScreen() {
  return (
    <View style={styles.container}>
      {/*<Text style={styles.title}>Profil</Text>*/}
      {/*<View style={styles.separator} lightColor="#eee" darkColor="rgba(255,255,255,0.1)" />*/}
      {/*<SettingsInfo path="/screens/TabTwoScreen.tsx" />*/}
      <ProfilePage path="/screens/ProfileScreen.tsx" />
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
  },
  title: {
    fontSize: 20,
    fontWeight: 'bold',
  },
  separator: {
    marginVertical: 30,
    height: 1,
    width: '80%',
  },
});
