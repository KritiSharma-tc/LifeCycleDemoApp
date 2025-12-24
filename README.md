# Android Lifecycle Logs -- Clean Readme

## 1. App Launch → MainActivity + HomeFragment

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

## 2. Click on Profile → Load ProfileFragment

        [HomeFragment]    onPause
        [HomeFragment]    onStop
        [ProfileFragment] onAttach
        [ProfileFragment] onCreate
        [ProfileFragment] onCreateView
        [ProfileFragment] onViewCreated
        [ProfileFragment] onStart
        [HomeFragment]    onDestroyView
        [HomeFragment]    onDestroy
        [HomeFragment]    onDetach
        [ProfileFragment] onResume

------------------------------------------------------------------------

## 3. Click DetailActivity → Open DetailActivity

        [HomeFragment]  onPause
    [MainActivity]      onPause
    [DetailActivity]    onStart
    [DetailActivity]    onResume
        [HomeFragment]  onStop
    [MainActivity]      onStop

------------------------------------------------------------------------

## 4. Click Back from DetailActivity → Return to MainActivity + HomeFragment

    [DetailActivity]    onPause
    [MainActivity]      onRestart
        [HomeFragment]  onStart
    [MainActivity]      onStart
    [MainActivity]      onResume
        [HomeFragment]  onResume
    [DetailActivity]    onStop
    [DetailActivity]    onDestroy

------------------------------------------------------------------------

## Notes

-   Activities control app-level lifecycle.
-   Fragments follow activity state but have their own view lifecycle.
-   `onRestart()` is called when returning to a stopped activity.
-   Logs are grouped and indented for better readability on Redmi and
    small screens.
