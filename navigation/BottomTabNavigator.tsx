import { Ionicons } from '@expo/vector-icons';
import { createBottomTabNavigator } from '@react-navigation/bottom-tabs';
import { createStackNavigator } from '@react-navigation/stack';
import * as React from 'react';

import Colors from '../constants/Colors';
import useColorScheme from '../hooks/useColorScheme';
import TabOneScreen from '../screens/TabOneScreen';
import {BottomTabParamList, LoginParamList, TabOneParamList, TabTwoParamList} from '../types';
import ProfileScreen from "../screens/ProfileScreen";

const BottomTab = createBottomTabNavigator<BottomTabParamList>();

export default function BottomTabNavigator() {
  const colorScheme = useColorScheme();

  return (
    <BottomTab.Navigator
      initialRouteName="Dashboard"
      tabBarOptions={{ activeTintColor: Colors[colorScheme].tint }}>
      <BottomTab.Screen
        name="Accueil"
        component={TabOneNavigator}
        options={{
          tabBarIcon: ({ color }) => <TabBarIcon name="home" color={color} />,
        }}
      />
        <BottomTab.Screen
            name="Profil"
            component={ProfilNavigator}
            options={{
                tabBarIcon: ({ color }) => <TabBarIcon name="person" color={color} />,
            }}
        />
      <BottomTab.Screen
        name="Parameter"
        component={ProfilNavigator}
        options={{
          tabBarIcon: ({ color }) => <TabBarIcon name="settings" color={color} />,
        }}
      />
    </BottomTab.Navigator>
  );
}

// You can explore the built-in icon families and icons on the web at:
// https://icons.expo.fyi/
function TabBarIcon(props: { name: React.ComponentProps<typeof Ionicons>['name']; color: string }) {
  return <Ionicons size={30} style={{ marginBottom: -3 }} {...props} />;
}

// Each tab has its own navigation stack, you can read more about this pattern here:
// https://reactnavigation.org/docs/tab-based-navigation#a-stack-navigator-for-each-tab
const TabOneStack = createStackNavigator<TabOneParamList>();
const loginStack = createStackNavigator<LoginParamList>();

function TabOneNavigator() {
  return (
    <TabOneStack.Navigator>
      <TabOneStack.Screen
        name="Accueil"
        component={TabOneScreen}
        options={{ headerTitle: 'Accueil' }}
      />
    </TabOneStack.Navigator>
  );
}

const profilStack = createStackNavigator<TabTwoParamList>();

function ProfilNavigator() {
  return (
    <profilStack.Navigator>
      <profilStack.Screen
        name="Profil"
        component={ProfileScreen}
        options={{ headerTitle: 'Profil' }}
      />
    </profilStack.Navigator>
  );
}

function LoginNavigator() {
    return (
        <loginStack.Navigator>
            <loginStack.Screen
                name="login"
                component={TabOneScreen}
                options={{ headerTitle: 'Dashboard' }}
            />
        </loginStack.Navigator>
    );
}
