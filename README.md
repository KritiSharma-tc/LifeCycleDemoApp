# 📱 Android Lifecycle Logs --- Clean README

This document explains Activity and Fragment lifecycle flows using real
Logcat outputs in different user scenarios.

## 1️⃣ App Launch → MainActivity + HomeFragment

    [MainActivity]      onCreate
        [HomeFragment]  onAttach
        [HomeFragment]  onCreate
        [HomeFragment]  onCreateView
        [HomeFragment]  onViewCreated
        [HomeFragment]  onStart
    [MainActivity]      onStart
    [MainActivity]      onResume
        [HomeFragment]  onResume

------------------------------------------------------------------------

## 2️⃣ Click Profile → Load ProfileFragment

        [HomeFragment]     onPause
        [HomeFragment]     onStop

        [ProfileFragment]  onAttach
        [ProfileFragment]  onCreate
        [ProfileFragment]  onCreateView
        [ProfileFragment]  onViewCreated
        [ProfileFragment]  onStart

        [HomeFragment]     onDestroyView
        [HomeFragment]     onDestroy
        [HomeFragment]     onDetach

        [ProfileFragment]  onResume

------------------------------------------------------------------------

## 3️⃣ Click DetailActivity → Open DetailActivity

        [HomeFragment]  onPause
    [MainActivity]      onPause

    [DetailActivity]    onStart
    [DetailActivity]    onResume

        [HomeFragment]  onStop
    [MainActivity]      onStop

------------------------------------------------------------------------

## 4️⃣ Back Press from DetailActivity → Return to Home

    [DetailActivity]    onPause

    [MainActivity]      onRestart
        [HomeFragment]  onStart
    [MainActivity]      onStart
    [MainActivity]      onResume
        [HomeFragment]  onResume

    [DetailActivity]    onStop
    [DetailActivity]    onDestroy

------------------------------------------------------------------------

## 5️⃣ Back Press from MainActivity → Exit App

        [HomeFragment]  onPause
    [MainActivity]      onPause

        [HomeFragment]  onStop
    [MainActivity]      onStop

        [HomeFragment]  onDestroyView
        [HomeFragment]  onDestroy
        [HomeFragment]  onDetach

    [MainActivity]      onDestroy

------------------------------------------------------------------------

## 6️⃣ Orientation Change Lifecycle (Portrait → Landscape)

### 🔄 Scenario

MainActivity opens in Portrait mode, then user rotates device to
Landscape mode.

### 🚀 Step 1: App Launch (Portrait)

    [MainActivity]      onCreate
        [HomeFragment]  onAttach
        [HomeFragment]  onCreate
        [HomeFragment]  onCreateView
        [HomeFragment]  onViewCreated
        [HomeFragment]  onStart
    [MainActivity]      onStart
    [MainActivity]      onResume
        [HomeFragment]  onResume

### 🔄 Step 2: Orientation Change Triggered

        [HomeFragment]  onPause
    [MainActivity]      onPause

        [HomeFragment]  onStop
    [MainActivity]      onStop

        [HomeFragment]  onDestroyView
        [HomeFragment]  onDestroy
        [HomeFragment]  onDetach

    [MainActivity]      onDestroy

### ♻️ Step 3: Recreated in Landscape Mode

    [MainActivity]      onCreate
        [HomeFragment]  onAttach
        [HomeFragment]  onCreate
        [HomeFragment]  onCreateView
        [HomeFragment]  onViewCreated
        [HomeFragment]  onStart
    [MainActivity]      onStart
    [MainActivity]      onResume
        [HomeFragment]  onResume
