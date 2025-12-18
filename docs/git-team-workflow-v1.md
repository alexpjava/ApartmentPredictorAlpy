# Git Team Workflow – Official Rules

## Purpose
Ensure that **local and remote repositories remain identical**, with a **clean and predictable history**, while working collaboratively using **feature branches**.

---

## Core Principles
- The **remote repository is the source of truth**
- No accidental merges
- Clean, linear history
- Feature branches are short-lived and focused

---

## Protected Branches
The following branches are **protected**:
- `main`
- `develop`

Rules:
- ❌ No direct commits
- ✅ Changes must go through Pull Requests
- ✅ CI and code review required

---

## Feature Branch Rules
- Naming convention: `feature/<short-description>`
  - Example: `feature/calculation-renovation-cost`
- A feature branch is owned by **one developer** or **explicitly coordinated**
- Rebase is allowed on feature branches
- Never rebase shared branches without coordination

---

## Creating a Feature Branch
```bash
git checkout develop
git pull --ff-only
git checkout -b feature/my-feature
git push -u origin feature/my-feature
```

### Command explanation
- `git checkout develop`  
  Switches to the `develop` branch.
- `git pull --ff-only`  
  Updates the local branch **only if a fast-forward is possible**.  
  Prevents automatic merges and ensures local = remote.
- `git checkout -b feature/my-feature`  
  Creates and switches to a new feature branch.
- `git push -u origin feature/my-feature`  
  Pushes the branch to the remote and sets the upstream reference.

---

## Daily Work
```bash
git add .
git commit -m "Clear, descriptive commit message"
git push
```

### Command explanation
- `git add .`  
  Stages all modified files for commit.
- `git commit`  
  Creates a snapshot of the staged changes.
- `git push`  
  Sends local commits to the remote repository.

Local and remote must always remain identical after pushing.

---

## Keeping a Feature Branch Up to Date
```bash
git fetch origin
git rebase origin/develop
```

### Command explanation
- `git fetch origin`  
  Downloads changes from the remote **without modifying** local branches.
- `git rebase origin/develop`  
  Reapplies local commits on top of the latest `develop`, creating a linear history.

If conflicts occur:
```bash
git add .
git rebase --continue
```

- `git rebase --continue`  
  Continues the rebase process after conflicts are resolved.

---

## Pushing After Rebase
```bash
git push --force-with-lease
```

### Command explanation
- `--force-with-lease`  
  Safely updates the remote branch **only if no one else has pushed changes**.
  Prevents accidental overwrites.

---

## Synchronizing Local with Remote (Exact Match)
If local and remote diverge and local changes must be discarded:

```bash
git fetch origin
git reset --hard origin/feature/my-feature
```

### Command explanation
- `git reset --hard`  
  Forces the local branch to exactly match the remote branch.
  ⚠️ Deletes all local-only commits and changes.

---

## Pull Configuration (Mandatory)
```bash
git config --global pull.ff only
```

### Command explanation
- Forces `git pull` to **only perform fast-forward updates**
- Prevents merge commits
- Ensures local and remote histories remain identical

---

## IDE and Local Files
IDE configuration files must **never** be committed.

Add to `.gitignore`:
```gitignore
.idea/
.vscode/
*.iml
```

---

## Pull Requests
- Base branch: `develop`
- Keep PRs small and focused
- Prefer **rebase or squash** merge strategies
- Delete feature branch after merge

---

## Forbidden Actions
❌ Direct commits to `main` or `develop`  
❌ Committing IDE files  
❌ `git pull` without `--ff-only`  
❌ `git push --force`  
❌ Long-lived feature branches  

---

## Mental Rule
> If local ≠ remote, **stop and synchronize consciously**.

---

## Summary
- Feature branches + rebase
- Protected main branches
- Fast-forward only pulls
- Remote is the source of truth
- Clean history at all times
