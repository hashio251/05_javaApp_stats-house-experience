# STATUS HOUSE CLI 設計書

## 演習1 コンセプトシート

| 記入項目 | 内容 |
| --- | --- |
| アプリ名 | STATUS HOUSE CLI - Visitor Log System |
| コンセプト | HTTPステータスコードをテーマにした館で、訪問者ログの登録・確認・編集・削除・検索を行えるCLIアプリ |
| 作ろうと思った理由 | HTTPステータスコードを数字や名称だけで覚えるのではなく、CRUD操作の結果と結びつけながら理解できるアプリを作りたいと考えたため |

---

## 演習2 ペルソナ

| 項目 | 記入内容 |
| --- | --- |
| 名前 | 山田 太郎 |
| 年齢 | 20歳 |
| 職業 | IT系専門学校生 |
| 趣味 | Web制作、プログラミング、ゲーム |
| 困っていること | HTTPステータスコードの数字と意味がなかなか結びつかない |
| 利用目的 | JavaのCRUD操作を練習しながらHTTPステータスコードにも触れたい |

---

## 演習3 ユーザーストーリー

| No. | ユーザーストーリー |
| --- | --- |
| 1 | 実際にHTTPステータスコードを体感し記録するため、訪問者ログを登録する。暗記で終わらせるのではなく、実際にルームコードやメッセージを登録し、記憶するため。     |
| 2 | 登録したログを一覧で確認する。どのようなルームコードやメッセージが登録されているのか確認するため。 |
| 3 | 登録したログの詳細を確認する。指定したログの名前、ルームコード、メッセージ、登録日時を確認するため。 |
| 4 | 登録した内容を編集する。後から変更をしたいと思った場合などに変更するため。    |
| 5 | 不要なログを削除する。誤って作成してしまったログなどを削除するため。     |
| 6 | IDからログを検索する。作成したIDごとにログを参照したい場合に使用するため。|


---

## 演習4 機能一覧

| No. | 機能名 | 概要 |
| --- | --- | --- |
| 1 | Visitor Check-in | 訪問者名・部屋番号・メッセージを入力してVisitor Logを登録する |
| 2 | Visitor Log List | 登録されているVisitor Logをすべて表示する |
| 3 | Visitor Log Details | IDを指定してVisitor Logの詳細を表示する |
| 4 | Edit Visitor Log | IDを指定してVisitor Logの内容を編集する |
| 5 | Delete Visitor Log | IDを指定してVisitor Logを削除する |
| 6 | Search by ID | IDからVisitor Logを検索する |
| 0 | Exit | アプリケーションを終了する |

### CRUDとの対応

| CRUD | 機能 |
| --- | --- |
| Create | Visitor Check-in |
| Read | Visitor Log List / Visitor Log Details / Search by ID |
| Update | Edit Visitor Log |
| Delete | Delete Visitor Log |

---

## 演習5 データ設計

| 項目名 | 内容 |
| --- | --- |
| id | Visitor Logを識別するための管理番号 |
| visitorName | 訪問者の名前 |
| roomCode | 訪問した部屋を表すHTTPステータスコード |
| message | 訪問者が残すメッセージ（部屋の説明：ステータスコードの意味など） |
| visitedAt | Visitor Logを登録した日時 |

### VisitorLogで使用する型

| フィールド名 | 型 |
| --- | --- |
| id | int |
| visitorName | String |
| roomCode | int（Stringで受け取ってからintへ変換） |
| message | String |
| visitedAt | String |

---

## 演習6 クラス設計

| クラス名 | 役割 |
| --- | --- |
| Main | アプリケーションの開始、各クラスの生成、メニュー処理の全体制御 |
| VisitorLog | Visitor Logのデータを保持するModelクラス |
| VisitorLogRepository | VisitorLogをArrayListで保管し、保存・取得・検索・削除を行う |
| VisitorLogService | 各VisitorLog Serviceで共通して使用するRepositoryを保持する親クラス |
| VisitorLogCreateService | Visitor Logの登録処理 |
| VisitorLogReadService | Visitor Logの一覧取得・ID検索 |
| VisitorLogUpdateService | Visitor Logの更新処理 |
| VisitorLogDeleteService | Visitor Logの削除処理 |
| Menu | 各Menuがshow()を持つことを決めるインターフェース |
| MainMenu | メインメニューの表示とメニュー番号の入力受付 |
| CreateMenu | Visitor Log登録時の入力・表示 |
| ListMenu | Visitor Log一覧の表示 |
| DetailMenu | Visitor Log詳細の入力・表示 |
| UpdateMenu | Visitor Log編集時の入力・表示 |
| DeleteMenu | Visitor Log削除時の入力・確認・表示 |
| SearchMenu | ID検索時の入力・表示 |
| VisitorLogCommonUI | Visitor Logの共通表示処理 |
| InputValidator | 空文字・数値・メニュー番号などの入力チェック |
| HttpStatus | HTTPステータスコードとメッセージを管理するenum |

---

## 簡易クラス図

```text
Main
 │
 ├── MainMenu
 │
 ├── Menu
 │    ├── CreateMenu
 │    ├── ListMenu
 │    ├── DetailMenu
 │    ├── UpdateMenu
 │    ├── DeleteMenu
 │    └── SearchMenu
 │
 ├── VisitorLogCommonUI
 │
 ├── VisitorLogService
 │    ├── VisitorLogCreateService
 │    ├── VisitorLogReadService
 │    ├── VisitorLogUpdateService
 │    └── VisitorLogDeleteService
 │
 ├── VisitorLogRepository
 │    └── List<VisitorLog>
 │
 ├── VisitorLog
 │
 ├── InputValidator
 │
 └── HttpStatus
