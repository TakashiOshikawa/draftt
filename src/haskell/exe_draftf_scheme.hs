
import System.Process

{-
  1.drafttデータベースを削除
  2.drafttデータベースを作成
  3.scalerにdrafttデータベースの操作権限付与
-}

main = do
        system "mysql -u root -e \"DROP DATABASE draftt;\""
        system "mysql -u root < /Users/oshikawatakashi/various/mySQL/er_table/draftt.sql"
        system "mysql -u root -e \"GRANT ALL PRIVILEGES ON draftt.* TO scaler@localhost;\""
