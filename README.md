📄 Clean Lifecycle Log (Redmi-Friendly)
1️⃣ App Launch → MainActivity + HomeFragment
[MainActivity]      onCreate
    [HomeFragment]  onAttach
    [HomeFragment]  onCreate
    [HomeFragment]  onCreateView
    [HomeFragment]  onViewCreated
    [HomeFragment]  onStart
[MainActivity]      onStart
[MainActivity]      onResume
    [HomeFragment]  onResume

2️⃣ Click on Profile → Load ProfileFragment
    [HomeFragment]  onPause
    [HomeFragment]  onStop
    [ProfileFragment] onAttach
    [ProfileFragment] onCreate
    [ProfileFragment] onCreateView
    [ProfileFragment] onViewCreated
    [ProfileFragment] onStart
    [HomeFragment]  onDestroyView
    [HomeFragment]  onDestroy
    [HomeFragment]  onDetach
    [ProfileFragment] onResume

3️⃣ Click DetailActivity → Open DetailActivity
    [HomeFragment]      onPause
[MainActivity]          onPause
[DetailActivity]        onStart
[DetailActivity]        onResume
    [HomeFragment]      onStop
[MainActivity]          onStop
