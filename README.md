# ProjAtlas

**Project Stucture : Packages**
  - ProjAtlas   : Game
  - AtlasEngine : Game Engine
  - MapMaker    : Map maker for the game itself.

**AtlasEngine**
Classes:
  - Window
  - Events
    - BuildPanel
      - GamePanel
      - MenuPanel
      - FightPanel
    - Entries
      - Player
      - Entry
  - DataProcessor
    - SavesProcessor
    - MapProcessor
    - ImageProcessor
      - Sprite
      - Image
    - AudioProcessor

**Project Atlas**
Classes:
  - Game
    - Window
      - GamePanel
        - Sprite
      - MenuPanel
      - FightPanel
        - Sprite
    - GameLogic
      - Time
      - Player
        - Item
      - Entry
      - Events
      - CombatSystem
